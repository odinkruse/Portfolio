from naoqi import ALProxy
names = list()
times = list()
keys = list()
class kick:
    def __init__(self):
        IP = "192.168.1.115"
        self.motion = ALProxy("ALMotion", IP, 9559)
        print"kick created"
    def kickmotion(self):
        names.append("HeadPitch")
        times.append([ 1.16000, 2.68000, 3.20000, 4.24000, 5.12000, 6.12000])
        keys.append([ [ 0.04363, [ 3, -0.38667, 0.00000], [ 3, 0.50667, 0.00000]], [ 0.26180, [ 3, -0.50667, 0.00000], [ 3, 0.17333, 0.00000]], [ 0.17453, [ 3, -0.17333, 0.06012], [ 3, 0.34667, -0.12023]], [ -0.27925, [ 3, -0.34667, 0.00000], [ 3, 0.29333, 0.00000]], [ -0.26180, [ 3, -0.29333, -0.00575], [ 3, 0.33333, 0.00653]], [ -0.24241, [ 3, -0.33333, 0.00000], [ 3, 0.00000, 0.00000]]])

        names.append("HeadYaw")
        times.append([ 1.16000, 2.68000, 3.20000, 4.24000, 5.12000, 6.12000])
        keys.append([ [ 0.00464, [ 3, -0.38667, 0.00000], [ 3, 0.50667, 0.00000]], [ -0.00149, [ 3, -0.50667, 0.00000], [ 3, 0.17333, 0.00000]], [ 0.00311, [ 3, -0.17333, 0.00000], [ 3, 0.34667, 0.00000]], [ -0.04905, [ 3, -0.34667, 0.00000], [ 3, 0.29333, 0.00000]], [ -0.03371, [ 3, -0.29333, -0.00382], [ 3, 0.33333, 0.00434]], [ -0.02459, [ 3, -0.33333, 0.00000], [ 3, 0.00000, 0.00000]]])

        names.append("LAnklePitch")
        times.append([ 1.04000, 1.76000, 2.56000, 4.12000, 5.00000, 6.00000])
        keys.append([ [ 0.03226, [ 3, -0.34667, 0.00000], [ 3, 0.24000, 0.00000]], [ 0.01745, [ 3, -0.24000, 0.00000], [ 3, 0.26667, 0.00000]], [ 0.01745, [ 3, -0.26667, 0.00000], [ 3, 0.52000, 0.00000]], [ 0.03491, [ 3, -0.52000, 0.00000], [ 3, 0.29333, 0.00000]], [ 0.03491, [ 3, -0.29333, 0.00000], [ 3, 0.33333, 0.00000]], [ 0.11501, [ 3, -0.33333, 0.00000], [ 3, 0.00000, 0.00000]]])

        names.append("LAnkleRoll")
        times.append([ 1.04000, 1.76000, 2.56000, 4.12000, 5.00000, 6.00000])
        keys.append([ [ 0.33161, [ 3, -0.34667, 0.00000], [ 3, 0.24000, 0.00000]], [ 0.36652, [ 3, -0.24000, 0.00000], [ 3, 0.26667, 0.00000]], [ 0.36652, [ 3, -0.26667, 0.00000], [ 3, 0.52000, 0.00000]], [ 0.36652, [ 3, -0.52000, 0.00000], [ 3, 0.29333, 0.00000]], [ 0.34732, [ 3, -0.29333, 0.01920], [ 3, 0.33333, -0.02182]], [ -0.08433, [ 3, -0.33333, 0.00000], [ 3, 0.00000, 0.00000]]])

        names.append("LElbowRoll")
        times.append([ 1.08000, 2.60000, 3.12000, 4.16000, 5.04000, 6.04000])
        keys.append([ [ -0.74096, [ 3, -0.36000, 0.00000], [ 3, 0.50667, 0.00000]], [ -1.03396, [ 3, -0.50667, 0.15621], [ 3, 0.17333, -0.05344]], [ -1.36990, [ 3, -0.17333, 0.00000], [ 3, 0.34667, 0.00000]], [ -1.02015, [ 3, -0.34667, -0.11965], [ 3, 0.29333, 0.10124]], [ -0.70722, [ 3, -0.29333, -0.10030], [ 3, 0.33333, 0.11398]], [ -0.37732, [ 3, -0.33333, 0.00000], [ 3, 0.00000, 0.00000]]])

        names.append("LElbowYaw")
        times.append([ 1.08000, 2.60000, 3.12000, 4.16000, 5.04000, 6.04000])
        keys.append([ [ -1.15353, [ 3, -0.36000, 0.00000], [ 3, 0.50667, 0.00000]], [ -0.95411, [ 3, -0.50667, -0.06096], [ 3, 0.17333, 0.02085]], [ -0.90809, [ 3, -0.17333, 0.00000], [ 3, 0.34667, 0.00000]], [ -1.23023, [ 3, -0.34667, 0.11716], [ 3, 0.29333, -0.09913]], [ -1.55697, [ 3, -0.29333, 0.00000], [ 3, 0.33333, 0.00000]], [ -1.14441, [ 3, -0.33333, 0.00000], [ 3, 0.00000, 0.00000]]])

        names.append("LHand")
        times.append([ 1.08000, 2.60000, 3.12000, 4.16000, 5.04000, 6.04000])
        keys.append([ [ 0.00317, [ 3, -0.36000, 0.00000], [ 3, 0.50667, 0.00000]], [ 0.00328, [ 3, -0.50667, -0.00003], [ 3, 0.17333, 0.00001]], [ 0.00329, [ 3, -0.17333, 0.00000], [ 3, 0.34667, 0.00000]], [ 0.00317, [ 3, -0.34667, 0.00000], [ 3, 0.29333, 0.00000]], [ 0.00325, [ 3, -0.29333, 0.00000], [ 3, 0.33333, 0.00000]], [ 0.00187, [ 3, -0.33333, 0.00000], [ 3, 0.00000, 0.00000]]])

        names.append("LHipPitch")
        times.append([ 1.04000, 2.56000, 3.08000, 3.36000, 4.12000, 5.00000, 6.00000])
        keys.append([ [ 0.23159, [ 3, -0.34667, 0.00000], [ 3, 0.50667, 0.00000]], [ 0.10580, [ 3, -0.50667, 0.00000], [ 3, 0.17333, 0.00000]], [ 0.12217, [ 3, -0.17333, 0.00000], [ 3, 0.09333, 0.00000]], [ 0.08433, [ 3, -0.09333, 0.00000], [ 3, 0.25333, 0.00000]], [ 0.09046, [ 3, -0.25333, -0.00614], [ 3, 0.29333, 0.00710]], [ 0.19171, [ 3, -0.29333, -0.01627], [ 3, 0.33333, 0.01849]], [ 0.21020, [ 3, -0.33333, 0.00000], [ 3, 0.00000, 0.00000]]])

        names.append("LHipRoll")
        times.append([ 1.04000, 2.56000, 3.08000, 3.36000, 4.12000, 5.00000, 6.00000])
        keys.append([ [ -0.34366, [ 3, -0.34667, 0.00000], [ 3, 0.50667, 0.00000]], [ -0.36820, [ 3, -0.50667, 0.00000], [ 3, 0.17333, 0.00000]], [ -0.36820, [ 3, -0.17333, 0.00000], [ 3, 0.09333, 0.00000]], [ -0.36513, [ 3, -0.09333, 0.00000], [ 3, 0.25333, 0.00000]], [ -0.36667, [ 3, -0.25333, 0.00000], [ 3, 0.29333, 0.00000]], [ -0.36513, [ 3, -0.29333, -0.00153], [ 3, 0.33333, 0.00174]], [ 0.10129, [ 3, -0.33333, 0.00000], [ 3, 0.00000, 0.00000]]])

        names.append("LHipYawPitch")
        times.append([ 1.04000, 2.56000, 3.08000, 3.36000, 4.12000, 5.00000, 6.00000])
        keys.append([ [ -0.18097, [ 3, -0.34667, 0.00000], [ 3, 0.50667, 0.00000]], [ -0.25307, [ 3, -0.50667, 0.00000], [ 3, 0.17333, 0.00000]], [ -0.06285, [ 3, -0.17333, -0.02279], [ 3, 0.09333, 0.01227]], [ -0.05058, [ 3, -0.09333, 0.00000], [ 3, 0.25333, 0.00000]], [ -0.18711, [ 3, -0.25333, 0.02986], [ 3, 0.29333, -0.03457]], [ -0.24386, [ 3, -0.29333, 0.02058], [ 3, 0.33333, -0.02339]], [ -0.31903, [ 3, -0.33333, 0.00000], [ 3, 0.00000, 0.00000]]])

        names.append("LKneePitch")
        times.append([ 1.04000, 1.76000, 2.56000, 3.08000, 3.36000, 4.12000, 5.00000, 6.00000])
        keys.append([ [ -0.08727, [ 3, -0.34667, 0.00000], [ 3, 0.24000, 0.00000]], [ -0.08727, [ 3, -0.24000, 0.00000], [ 3, 0.26667, 0.00000]], [ -0.09235, [ 3, -0.26667, 0.00000], [ 3, 0.17333, 0.00000]], [ -0.07973, [ 3, -0.17333, 0.00000], [ 3, 0.09333, 0.00000]], [ -0.07973, [ 3, -0.09333, 0.00000], [ 3, 0.25333, 0.00000]], [ -0.07819, [ 3, -0.25333, -0.00047], [ 3, 0.29333, 0.00055]], [ -0.07666, [ 3, -0.29333, 0.00000], [ 3, 0.33333, 0.00000]], [ -0.09208, [ 3, -0.33333, 0.00000], [ 3, 0.00000, 0.00000]]])

        names.append("LShoulderPitch")
        times.append([ 1.08000, 2.60000, 3.12000, 4.16000, 5.04000, 6.04000])
        keys.append([ [ 1.48649, [ 3, -0.36000, 0.00000], [ 3, 0.50667, 0.00000]], [ 1.35917, [ 3, -0.50667, 0.00000], [ 3, 0.17333, 0.00000]], [ 1.41746, [ 3, -0.17333, -0.02659], [ 3, 0.34667, 0.05318]], [ 1.59847, [ 3, -0.34667, -0.03988], [ 3, 0.29333, 0.03375]], [ 1.63835, [ 3, -0.29333, 0.00000], [ 3, 0.33333, 0.00000]], [ 1.50021, [ 3, -0.33333, 0.00000], [ 3, 0.00000, 0.00000]]])

        names.append("LShoulderRoll")
        times.append([ 1.08000, 2.60000, 3.12000, 4.16000, 5.04000, 6.04000])
        keys.append([ [ 0.02305, [ 3, -0.36000, 0.00000], [ 3, 0.50667, 0.00000]], [ 0.01998, [ 3, -0.50667, 0.00000], [ 3, 0.17333, 0.00000]], [ 0.13197, [ 3, -0.17333, 0.00000], [ 3, 0.34667, 0.00000]], [ 0.11816, [ 3, -0.34667, 0.01381], [ 3, 0.29333, -0.01168]], [ 0.02305, [ 3, -0.29333, 0.00000], [ 3, 0.33333, 0.00000]], [ 0.03524, [ 3, -0.33333, 0.00000], [ 3, 0.00000, 0.00000]]])

        names.append("LWristYaw")
        times.append([ 1.08000, 2.60000, 3.12000, 4.16000, 5.04000, 6.04000])
        keys.append([ [ 0.24435, [ 3, -0.36000, 0.00000], [ 3, 0.50667, 0.00000]], [ 0.23935, [ 3, -0.50667, 0.00500], [ 3, 0.17333, -0.00171]], [ 0.22094, [ 3, -0.17333, 0.00409], [ 3, 0.34667, -0.00818]], [ 0.20253, [ 3, -0.34667, 0.00554], [ 3, 0.29333, -0.00469]], [ 0.19026, [ 3, -0.29333, 0.01227], [ 3, 0.33333, -0.01394]], [ -0.12736, [ 3, -0.33333, 0.00000], [ 3, 0.00000, 0.00000]]])

        names.append("RAnklePitch")
        times.append([ 1.04000, 1.32000, 1.76000, 2.24000, 2.56000, 2.84000, 3.08000, 3.36000, 3.68000, 4.12000, 5.00000, 6.00000])
        keys.append([ [ 0.08727, [ 3, -0.34667, 0.00000], [ 3, 0.09333, 0.00000]], [ -0.08727, [ 3, -0.09333, 0.08824], [ 3, 0.14667, -0.13866]], [ -0.59341, [ 3, -0.14667, 0.00000], [ 3, 0.16000, 0.00000]], [ -0.40143, [ 3, -0.16000, -0.14312], [ 3, 0.10667, 0.09541]], [ 0.12217, [ 3, -0.10667, 0.00000], [ 3, 0.09333, 0.00000]], [ -0.05236, [ 3, -0.09333, 0.04386], [ 3, 0.08000, -0.03759]], [ -0.12217, [ 3, -0.08000, 0.00000], [ 3, 0.09333, 0.00000]], [ 0.24435, [ 3, -0.09333, 0.00000], [ 3, 0.10667, 0.00000]], [ -0.12217, [ 3, -0.10667, 0.12468], [ 3, 0.14667, -0.17144]], [ -0.64403, [ 3, -0.14667, 0.00000], [ 3, 0.29333, 0.00000]], [ -0.21991, [ 3, -0.29333, -0.11820], [ 3, 0.33333, 0.13432]], [ 0.11356, [ 3, -0.33333, 0.00000], [ 3, 0.00000, 0.00000]]])

        names.append("RAnkleRoll")
        times.append([ 1.04000, 2.56000, 3.08000, 3.36000, 4.12000, 5.00000, 6.00000])
        keys.append([ [ 0.40143, [ 3, -0.34667, 0.00000], [ 3, 0.50667, 0.00000]], [ 0.10887, [ 3, -0.50667, 0.00000], [ 3, 0.17333, 0.00000]], [ 0.13802, [ 3, -0.17333, 0.00000], [ 3, 0.09333, 0.00000]], [ 0.00000, [ 3, -0.09333, 0.00000], [ 3, 0.25333, 0.00000]], [ 0.18097, [ 3, -0.25333, -0.05338], [ 3, 0.29333, 0.06181]], [ 0.34558, [ 3, -0.29333, 0.00000], [ 3, 0.33333, 0.00000]], [ 0.05066, [ 3, -0.33333, 0.00000], [ 3, 0.00000, 0.00000]]])

        names.append("RElbowRoll")
        times.append([ 1.00000, 2.52000, 3.04000, 4.08000, 4.96000, 5.96000])
        keys.append([ [ 0.64117, [ 3, -0.33333, 0.00000], [ 3, 0.50667, 0.00000]], [ 1.15353, [ 3, -0.50667, -0.18364], [ 3, 0.17333, 0.06282]], [ 1.38056, [ 3, -0.17333, 0.00000], [ 3, 0.34667, 0.00000]], [ 1.36062, [ 3, -0.34667, 0.01994], [ 3, 0.29333, -0.01687]], [ 0.96024, [ 3, -0.29333, 0.14120], [ 3, 0.33333, -0.16046]], [ 0.45564, [ 3, -0.33333, 0.00000], [ 3, 0.00000, 0.00000]]])

        names.append("RElbowYaw")
        times.append([ 1.00000, 2.52000, 3.04000, 4.08000, 4.96000, 5.96000])
        keys.append([ [ 0.99714, [ 3, -0.33333, 0.00000], [ 3, 0.50667, 0.00000]], [ 0.86368, [ 3, -0.50667, 0.00000], [ 3, 0.17333, 0.00000]], [ 0.90970, [ 3, -0.17333, 0.00000], [ 3, 0.34667, 0.00000]], [ 0.63205, [ 3, -0.34667, 0.00000], [ 3, 0.29333, 0.00000]], [ 0.84834, [ 3, -0.29333, -0.13498], [ 3, 0.33333, 0.15339]], [ 1.49714, [ 3, -0.33333, 0.00000], [ 3, 0.00000, 0.00000]]])

        names.append("RHand")
        times.append([ 1.00000, 2.52000, 3.04000, 4.08000, 4.96000, 5.96000])
        keys.append([ [ 0.00129, [ 3, -0.33333, 0.00000], [ 3, 0.50667, 0.00000]], [ 0.00136, [ 3, -0.50667, 0.00000], [ 3, 0.17333, 0.00000]], [ 0.00132, [ 3, -0.17333, 0.00001], [ 3, 0.34667, -0.00002]], [ 0.00128, [ 3, -0.34667, 0.00000], [ 3, 0.29333, 0.00000]], [ 0.00133, [ 3, -0.29333, -0.00005], [ 3, 0.33333, 0.00006]], [ 0.00391, [ 3, -0.33333, 0.00000], [ 3, 0.00000, 0.00000]]])

        names.append("RHipPitch")
        times.append([ 1.04000, 2.56000, 3.08000, 3.36000, 4.12000, 5.00000, 6.00000])
        keys.append([ [ 0.16265, [ 3, -0.34667, 0.00000], [ 3, 0.50667, 0.00000]], [ -0.39726, [ 3, -0.50667, 0.31826], [ 3, 0.17333, -0.10888]], [ -1.11876, [ 3, -0.17333, 0.00190], [ 3, 0.09333, -0.00102]], [ -1.11978, [ 3, -0.09333, 0.00000], [ 3, 0.25333, 0.00000]], [ -0.78540, [ 3, -0.25333, -0.12796], [ 3, 0.29333, 0.14816]], [ -0.29142, [ 3, -0.29333, -0.15581], [ 3, 0.33333, 0.17705]], [ 0.21318, [ 3, -0.33333, 0.00000], [ 3, 0.00000, 0.00000]]])

        names.append("RHipRoll")
        times.append([ 1.04000, 2.56000, 3.08000, 3.36000, 4.12000, 5.00000, 6.00000])
        keys.append([ [ -0.47124, [ 3, -0.34667, 0.00000], [ 3, 0.50667, 0.00000]], [ -0.54001, [ 3, -0.50667, 0.00000], [ 3, 0.17333, 0.00000]], [ -0.32218, [ 3, -0.17333, -0.09040], [ 3, 0.09333, 0.04868]], [ -0.12276, [ 3, -0.09333, 0.00000], [ 3, 0.25333, 0.00000]], [ -0.36360, [ 3, -0.25333, 0.04547], [ 3, 0.29333, -0.05265]], [ -0.41713, [ 3, -0.29333, 0.00000], [ 3, 0.33333, 0.00000]], [ -0.05825, [ 3, -0.33333, 0.00000], [ 3, 0.00000, 0.00000]]])

        names.append("RKneePitch")
        times.append([ 1.04000, 2.56000, 2.84000, 3.08000, 3.36000, 4.12000, 5.00000, 6.00000])
        keys.append([ [ -0.08901, [ 3, -0.34667, 0.00000], [ 3, 0.50667, 0.00000]], [ 1.97575, [ 3, -0.50667, 0.00000], [ 3, 0.09333, 0.00000]], [ 1.97222, [ 3, -0.09333, 0.00353], [ 3, 0.08000, -0.00302]], [ 1.23918, [ 3, -0.08000, 0.26583], [ 3, 0.09333, -0.31013]], [ 0.24435, [ 3, -0.09333, 0.00000], [ 3, 0.25333, 0.00000]], [ 1.53589, [ 3, -0.25333, 0.00000], [ 3, 0.29333, 0.00000]], [ 0.62430, [ 3, -0.29333, 0.25160], [ 3, 0.33333, -0.28591]], [ -0.07666, [ 3, -0.33333, 0.00000], [ 3, 0.00000, 0.00000]]])

        names.append("RShoulderPitch")
        times.append([ 1.00000, 2.52000, 3.04000, 4.08000, 4.96000, 5.96000])
        keys.append([ [ 1.52782, [ 3, -0.33333, 0.00000], [ 3, 0.50667, 0.00000]], [ 1.46033, [ 3, -0.50667, 0.00000], [ 3, 0.17333, 0.00000]], [ 1.47413, [ 3, -0.17333, 0.00000], [ 3, 0.34667, 0.00000]], [ 1.24096, [ 3, -0.34667, 0.00000], [ 3, 0.29333, 0.00000]], [ 1.51862, [ 3, -0.29333, -0.02707], [ 3, 0.33333, 0.03076]], [ 1.54938, [ 3, -0.33333, 0.00000], [ 3, 0.00000, 0.00000]]])

        names.append("RShoulderRoll")
        times.append([ 1.00000, 2.52000, 3.04000, 4.08000, 4.96000, 5.96000])
        keys.append([ [ -0.12268, [ 3, -0.33333, 0.00000], [ 3, 0.50667, 0.00000]], [ -0.04138, [ 3, -0.50667, 0.00000], [ 3, 0.17333, 0.00000]], [ -0.14569, [ 3, -0.17333, 0.00000], [ 3, 0.34667, 0.00000]], [ -0.13955, [ 3, -0.34667, 0.00000], [ 3, 0.29333, 0.00000]], [ -0.14722, [ 3, -0.29333, 0.00000], [ 3, 0.33333, 0.00000]], [ -0.03993, [ 3, -0.33333, 0.00000], [ 3, 0.00000, 0.00000]]])

        names.append("RWristYaw")
        times.append([ 1.00000, 2.52000, 3.04000, 4.08000, 4.96000, 5.96000])
        keys.append([ [ -0.08727, [ 3, -0.33333, 0.00000], [ 3, 0.50667, 0.00000]], [ -0.07359, [ 3, -0.50667, -0.00911], [ 3, 0.17333, 0.00312]], [ -0.05058, [ 3, -0.17333, 0.00000], [ 3, 0.34667, 0.00000]], [ -0.06285, [ 3, -0.34667, 0.00000], [ 3, 0.29333, 0.00000]], [ 0.05680, [ 3, -0.29333, 0.00000], [ 3, 0.33333, 0.00000]], [ 0.00149, [ 3, -0.33333, 0.00000], [ 3, 0.00000, 0.00000]]])
        self.motion.angleInterpolationBezier(names, times, keys);