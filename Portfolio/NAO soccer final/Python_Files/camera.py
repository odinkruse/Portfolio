import cv2.cv as cv, Image, time
from naoqi import ALProxy
IP = "192.168.1.109"

camProxy = ALProxy("ALVideoDevice", IP, 9559)
print "camProxy done"
videoClient = camProxy.subscribe("python_client", 1, 11, 5)
print "subscribe done"
print "init done"
cv.NamedWindow("robot", 1)
while True:
    img = camProxy.getImageRemote(videoClient)
    im = Image.fromstring("RGB", (img[0], img[1]), img[6])
    out = cv.CreateImageHeader(im.size, cv.IPL_DEPTH_8U, 3)
    cv.SetData(out, im.tostring(), im.size[0]*3)
    cv.ShowImage("robot", out)
    if cv.WaitKey(10) == 32:
        camProxy.setParam(18, 1)
    if cv.WaitKey(10) == 120:
        camProxy.setParam(18, 0);
    if cv.WaitKey(10) == 27:
        break
camProxy.unsubscribe(videoClient)    
cv.DestroyWindow("robot")
cv.DestroyWindow("ball")
