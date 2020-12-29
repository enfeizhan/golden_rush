import cv2
import pytesseract

img = cv2.imread('example.jpg')
img = cv2.cvtColor(img, cv2.COLOR_BGR2RGB)
# print(pytesseract.image_to_string(img))
hImg, wImg, _ = img.shape
boxes = pytesseract.image_to_data(img)

for b in boxes.splitlines()[1:]:
    b = b.split('\t')
    # print(b)
    if len(b) == 12:
        x1, y1, w, h = int(b[6]), int(b[7]), int(b[8]), int(b[9])
        cv2.rectangle(img, (x1, y1), (x1+w, y1+h), (0, 0, 255), 2)
        cv2.putText(img, b[11], (x1, y1), cv2.FONT_HERSHEY_COMPLEX, 2, (255, 50, 0), 2)
cv2.imshow('result', img)
cv2.waitKey(0)
