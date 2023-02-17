fun main() {
    print(solution("aba"))
}

fun solution(s: String): Int {
    val map = HashMap<Char, Int>()
    var tempSquare = ""
    for (i in s.indices) {
        tempSquare += "9"
        map[s[i]] = (map[s[i]] ?: 0) + 1
    }
    for (i in tempSquare.toInt() downTo 0) {
        val squareRoot = Math.sqrt(i.toDouble())
        val floor = Math.floor(squareRoot)
        val tempMap = HashMap<Char, Int>()
        if (squareRoot == floor) {
            val sqrtString = i.toString()
            for (j in sqrtString.indices) {
                tempMap[sqrtString[j]] = (tempMap[sqrtString[j]] ?: 0) + 1
            }
            var sameFrequency = 0
            val filterMap = HashMap(map)
            tempMap.forEach {
                if (filterMap.containsValue(it.value)) {
                    sameFrequency++
                    var key: Char? = null
                    filterMap.forEach { it1 ->
                        if (it1.value == it.value) {
                            key = it1.key
                        }
                    }
                    filterMap.remove(key)
                }
            }
            if (sameFrequency == map.size)
                return i
        }
    }

    return -1
}