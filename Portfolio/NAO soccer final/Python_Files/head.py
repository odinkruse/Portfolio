from naoqi import ALProxy
names = list()
times = list()
keys = list()
class head:
    def __init__(self):
        IP = "192.168.1.115"
        self.motion = ALProxy("ALMotion",IP,9559)
        print"headtilt"
    def headdown(self):
        names.append("HeadPitch")
        times.append([ 1.00000])
        keys.append([ [ 0.32517, [ 3, -0.33333, 0.00000], [ 3, 0.00000, 0.00000]]])

        names.append("HeadYaw")
        times.append([ 1.00000])
        keys.append([ [ -0.01231, [ 3, -0.33333, 0.00000], [ 3, 0.00000, 0.00000]]])

        names.append("LAnklePitch")
        times.append([ 1.00000])
        keys.append([ [ 0.09813, [ 3, -0.33333, 0.00000], [ 3, 0.00000, 0.00000]]])

        names.append("LAnkleRoll")
        times.append([ 1.00000])
        keys.append([ [ -0.11808, [ 3, -0.33333, 0.00000], [ 3, 0.00000, 0.00000]]])

        names.append("LElbowRoll")
        times.append([ 1.00000])
        keys.append([ [ -0.43561, [ 3, -0.33333, 0.00000], [ 3, 0.00000, 0.00000]]])

        names.append("LElbowYaw")
        times.append([ 1.00000])
        keys.append([ [ -1.19810, [ 3, -0.33333, 0.00000], [ 3, 0.00000, 0.00000]]])

        names.append("LHipPitch")
        times.append([ 1.00000])
        keys.append([ [ 0.13657, [ 3, -0.33333, 0.00000], [ 3, 0.00000, 0.00000]]])

        names.append("LHipRoll")
        times.append([ 1.00000])
        keys.append([ [ 0.11663, [ 3, -0.33333, 0.00000], [ 3, 0.00000, 0.00000]]])

        names.append("LHipYawPitch")
        times.append([ 1.00000])
        keys.append([ [ -0.17023, [ 3, -0.33333, 0.00000], [ 3, 0.00000, 0.00000]]])

        names.append("LKneePitch")
        times.append([ 1.00000])
        keys.append([ [ -0.09055, [ 3, -0.33333, 0.00000], [ 3, 0.00000, 0.00000]]])

        names.append("LShoulderPitch")
        times.append([ 1.00000])
        keys.append([ [ 1.47106, [ 3, -0.33333, 0.00000], [ 3, 0.00000, 0.00000]]])

        names.append("LShoulderRoll")
        times.append([ 1.00000])
        keys.append([ [ 0.10120, [ 3, -0.33333, 0.00000], [ 3, 0.00000, 0.00000]]])

        names.append("RAnklePitch")
        times.append([ 1.00000])
        keys.append([ [ 0.10282, [ 3, -0.33333, 0.00000], [ 3, 0.00000, 0.00000]]])

        names.append("RAnkleRoll")
        times.append([ 1.00000])
        keys.append([ [ 0.07367, [ 3, -0.33333, 0.00000], [ 3, 0.00000, 0.00000]]])

        names.append("RElbowRoll")
        times.append([ 1.00000])
        keys.append([ [ 0.42496, [ 3, -0.33333, 0.00000], [ 3, 0.00000, 0.00000]]])

        names.append("RElbowYaw")
        times.append([ 1.00000])
        keys.append([ [ 1.17040, [ 3, -0.33333, 0.00000], [ 3, 0.00000, 0.00000]]])

        names.append("RHipPitch")
        times.append([ 1.00000])
        keys.append([ [ 0.13342, [ 3, -0.33333, 0.00000], [ 3, 0.00000, 0.00000]]])

        names.append("RHipRoll")
        times.append([ 1.00000])
        keys.append([ [ -0.06439, [ 3, -0.33333, 0.00000], [ 3, 0.00000, 0.00000]]])

        names.append("RHipYawPitch")
        times.append([ 1.00000])
        keys.append([ [ -0.17023, [ 3, -0.33333, 0.00000], [ 3, 0.00000, 0.00000]]])

        names.append("RKneePitch")
        times.append([ 1.00000])
        keys.append([ [ -0.09046, [ 3, -0.33333, 0.00000], [ 3, 0.00000, 0.00000]]])

        names.append("RShoulderPitch")
        times.append([ 1.00000])
        keys.append([ [ 1.50029, [ 3, -0.33333, 0.00000], [ 3, 0.00000, 0.00000]]])

        names.append("RShoulderRoll")
        times.append([ 1.00000])
        keys.append([ [ -0.11509, [ 3, -0.33333, 0.00000], [ 3, 0.00000, 0.00000]]])
        self.motion.angleInterpolationBezier(names, times, keys);
