from naoqi import ALProxy
from head import head

class movement:
        def __init__(self):
                IP = "192.168.1.115"
                self.head = head()
                self.motion = ALProxy("ALMotion", IP, 9559)
                self.posture = ALProxy("ALRobotPosture", IP, 9559)
                self.tts = ALProxy("ALTextToSpeech", IP, 9559)
        def stand(self):
                print "standing"
                self.posture.goToPosture("Stand", .9)
                self.head.headdown()
                pass
        def walk(self):
                print "walking"
                self.motion.walkTo(0.2, 0.0, 0.0)
                pass
        def sit(self):
                print "Sitting"
                self.posture.goToPosture("Sit", 1)
                pass
        def turnLeft(self):
                print "Turning"
                self.motion.walkTo(0.0, 0.0, 0.5)
                pass
        def turnRight(self):
                print "Turning"
                self.motion.walkTo(0.0, 0.0, -0.5)
                pass
        def stop(self):
                print "stopping"
                self.posture.goToPosture("Stand",.8)
                pass
        def shiftLeft(self):
                print "Shifting Left"
                self.motion.walkTo(0.0, 0.05, 0.0)
                pass
        def shiftRight(self):
                print "Shifting Right"
                self.motion.walkTo(0.0, -0.05, 0.0)
                pass

