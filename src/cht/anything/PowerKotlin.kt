package cht.anything

/**
 *
 * TODO
 * @author chenhantao
 * @since 2021/6/27
 */
class PowerKotlin {

    companion object {
        fun power(base: Int, power: Int): Unit {
            val result: MutableList<Int> = ArrayList()
            for (i in 0 until power) {
                if (result.isEmpty()) {
                    result.add(base)
                } else {
                    var temp: Int = 0
                    for (j in result.indices) {
                        val num: Int = result[j] * base + temp
                        temp = num / 10
                        val setValue: Int = num % 10
                        result[j] = setValue
                    }
                    if (temp > 0) {
                        result.add(temp)
                    }
                }
            }
            val stringBuilder = StringBuilder()
            for (i in result.indices.reversed()) {
                stringBuilder.append(result[i])
            }
            println("结果是： $stringBuilder")

        }
    }


}


fun main() {
    PowerKotlin.power(2, 1000);
}