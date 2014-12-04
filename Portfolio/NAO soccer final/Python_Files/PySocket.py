import socket, time
#from button import Button
from movement import movement
from kick import kick

class PySocket(object):
        def __init__(self):
                self.movement = movement()
                self.kick = kick()
                self.TCP_IP = '192.168.1.120'#my computer
                self.TCP_PORT = 5005
                self.BUFFER_SIZE = 20  # Normally 1024, but we want fast response
                self.s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
                print "before bind"
                self.s.bind((self.TCP_IP, self.TCP_PORT))
                print "before listen"
                self.s.listen(2)
                print 'before accept'
        def connectionWait(self):
                conn, addr = self.s.accept()
               
                print 'Connection address:', addr
                data = "anything"
                while data != 'exit':
                    word = conn.recv(self.BUFFER_SIZE)
                    if data: 
                        print "received data:", data, len(data),
                        data = word[:-1]
                        for i in data:
                            print "i: " + i
                        if data == "walk":
                            self.movement.walk();
                        elif data == "stand":
                            self.movement.stand();
                        elif data == "sit":
                            self.movement.sit()
                        elif data == "turnleft":
                            self.movement.turnLeft();
                        elif data == "turnright":
                            self.movement.turnRight();
                        elif data == "shiftleft":
                            self.movement.shiftLeft();
                        elif data == "shiftright":
                            self.movement.shiftRight();
                        elif data == "kick":
                            print "kicking"
                            self.kick.kickmotion()
                        #elif data == "talk":
                        #    self.nao.talk("Hunter is Cool")
                        else:
                            print "no make sense " + data
                        conn.send(word)
                        time.sleep(.3)
                conn.close()
run = PySocket()
run.connectionWait()

