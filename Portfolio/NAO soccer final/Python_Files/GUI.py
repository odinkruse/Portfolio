from graphics import *
from button import Button
from movement import movement

class GUI(object):
    def __init__(self):
        self.movement = movement()

    def button_window(self):
        win = GraphWin("Demo Program")
        win.setCoords(0, 0, 10, 12)
        win.setBackground("black")
    
        standButt = Button(win, Point(5, 11), 5, 1, "Stand")
        sitButt = Button(win, Point(5, 10), 5, 1, "Sit")
        walkButt = Button(win, Point(5, 9), 5, 1, "Walk")
        shiftleftButt=Button(win, Point(5, 8), 5, 1, "Shift Left")
        shiftrightButt=Button(win, Point(5, 7), 5, 1, "Shift Right")
        leftButt = Button(win, Point(5, 6), 5, 1, "Turn Left")
        rightButt = Button(win, Point(5, 5), 5, 1, "Turn Right")
        stopButt = Button(win, Point(5, 4), 5, 1, "Stop")
        kickButt = Button(win, Point(5, 3), 5, 1, "Kick")
        quitButt = Button(win, Point(5, 1), 2, 1, "quit")
        standButt.activate()
        sitButt.activate()
        walkButt.activate()
        shiftleftButt.activate()
        shiftrightButt.activate()
        leftButt.activate()
        rightButt.activate()
        stopButt.activate()
        kickButt.activate()
        quitButt.activate()

        pt = win.getMouse()
        while not quitButt.clicked(pt):
            pt = win.getMouse()
            if standButt.clicked(pt):
                print "stand clicked"
                self.movement.stand()
            if sitButt.clicked(pt):
                print "sit clicked"
                self.movement.sit()
            if walkButt.clicked(pt):
                print "walk clicked"
                self.movement.walk()
            if shiftleftButt.clicked(pt):
                print "shift left clicked"
                self.movement.shiftLeft()
            if shiftrightButt.clicked(pt):
                print "shift right clicked"
                self.movement.shiftRight()
            if leftButt.clicked(pt):
                print "turn left clicked"
                self.movement.turnLeft()
            if rightButt.clicked(pt):
                print "turn right clicked"
                self.movement.turnRight()
            if stopButt.clicked(pt):
                print "stop clicked"
                self.movement.stop()
            if kickButt.clicked(pt):
                print "kick clicked"
                self.movement.kick()
                
        win.close()

run = GUI()
run.button_window()

