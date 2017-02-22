def start, step1, step2, step3, step4, step5, step6, end

start = { box ->
    println "start $box"
    step1.call(box)
}

step1 = { box ->
    println "step1 $box"
    box[0] = box[3] - box[box[6] - 1]
    step2.call(box)
}

def secondBoxMentionedInStep2 = 5
step2 = { box ->
    println "step2 $box"
    box[0] = box[0] + box[secondBoxMentionedInStep2]
    step3.call(box)
}

step3 = { box ->
    println "step3 $box"
    if (box[0] % 4 == 0) {
        step2.call(box)
    } else {
        step4.call(box)
    }
}

step4 = { box ->
    println "step4 $box"
    secondBoxMentionedInStep2 += box[box[4] - 1]
    step5.call(box)
}

step5 = { box ->
    println "step5 $box"
    if (box[1] > secondBoxMentionedInStep2 + 1) {
        step6.call(box)
    } else {
        end.call(box)
    }
}

step6 = { box ->
    println "step6 $box"
    box[8]--
    step2.call(box)
}

end = { box ->
    println "end $box"
    println "result=${box[0]}"
}

start([4, 13, 2, 5, 6, 3, 10, 6, 7, 2, 5, 2, 6, 7, 1])
