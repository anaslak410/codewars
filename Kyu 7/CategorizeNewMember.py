def openOrSenior(data):
    listos = []
    for i in data :
        if i[0] > 54 and i[1] > 7 :
            listos.append("Senior")
        else :
            listos.append("Open")

    return listos