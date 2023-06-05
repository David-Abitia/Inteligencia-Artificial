#instalar estas dependencias
#pip install opencv-python
#pip install dlib
#pip install numpy
#pip install os
#pip install cv2
#pip install math

import cv2
import dlib
import numpy as np
import math
import os


def calculate_confidence(face_distance, face_match_threshold=0.6):
    range_val = (1.0 - face_match_threshold)
    linear_val = (1.0 - face_distance) / (range_val * 2.0)

    if face_distance > face_match_threshold:
        return str(round(linear_val * 100, 2)) + '%'
    else:
        value = (linear_val + ((1.0 - linear_val) * math.pow((linear_val - 0.5) * 2, 0.2))) * 100
        return str(round(value, 2)) + '%'


class FaceRecognition:
    def __init__(self):
        self.detector = dlib.get_frontal_face_detector()
        self.predictor = dlib.shape_predictor("shape_predictor_68_face_landmarks.dat")
        self.known_face_descriptors = []
        self.known_face_names = []
        self.load_known_faces()

    def load_known_faces(self):
        for file_name in os.listdir('faces'):
            name = os.path.splitext(file_name)[0]
            image_path = os.path.join('faces', file_name)
            image = cv2.imread(image_path)
            face_descriptor = self.get_face_descriptor(image)
            self.known_face_descriptors.append(face_descriptor)
            self.known_face_names.append(name)

    def get_face_descriptor(self, image):
        gray = cv2.cvtColor(image, cv2.COLOR_BGR2GRAY)
        faces = self.detector(gray)
        shape = self.predictor(gray, faces[0])
        face_descriptor = np.array(face_recognition.face_encodings(image, [shape.rect]))
        return face_descriptor

    def recognize_faces(self):
        video_capture = cv2.VideoCapture(0)

        if not video_capture.isOpened():
            print('Error opening video capture.')
            return

        while True:
            ret, frame = video_capture.read()

            face_descriptor = self.get_face_descriptor(frame)

            face_names = []
            for known_face_descriptor, known_face_name in zip(self.known_face_descriptors, self.known_face_names):
                face_distance = np.linalg.norm(known_face_descriptor - face_descriptor)
                name = "Unknown"
                confidence = '???'

                if face_distance < 0.6:
                    name = known_face_name
                    confidence = calculate_confidence(face_distance)

                face_names.append(f'{name} ({confidence})')

            for (top, right, bottom, left), name in zip(face_locations, face_names):
                cv2.rectangle(frame, (left, top), (right, bottom), (0, 0, 255), 2)
                cv2.rectangle(frame, (left, bottom - 35), (right, bottom), (0, 0, 255), cv2.FILLED)
                cv2.putText(frame, name, (left + 6, bottom - 6), cv2.FONT_HERSHEY_DUPLEX, 0.8, (255, 255, 255), 1)

            cv2.imshow('Face Recognition', frame)

            if cv2.waitKey(1) & 0xFF == ord('q'):
                break

        video_capture.release()
        cv2.destroyAllWindows()


if __name__ == '__main__':
    fr = FaceRecognition()
    fr.recognize_faces()
