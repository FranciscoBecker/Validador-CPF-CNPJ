class CPF {
    companion object {
        fun isValid(aCPF: String): Boolean {
            val lCPF = removeMask(aCPF)
            return hasElevenDigits(lCPF) and
                    !isRepeatedNumbers(lCPF) and
                    areValidDigits(lCPF, true) and
                    areValidDigits(lCPF, false)
        }

        private fun removeMask(aCPF: String): String {
            return aCPF.replace(".", "")
                .replace("-", "")
        }

        private fun hasElevenDigits(aCPF: String) = aCPF.length == 11

        private fun isRepeatedNumbers(aCPF: String): Boolean {
            for (lNumber in aCPF) {
                if (lNumber != aCPF[0])
                    return false
            }
            return true
        }

        private fun areValidDigits(aCPF: String, isFirstDigit: Boolean): Boolean {
            var lSum = 0
            var lMultiplier = if (isFirstDigit) 10 else 11
            val lEndPosition = if (isFirstDigit) 9 else 10
            val lRootCPF = aCPF.substring(0, lEndPosition)

            lRootCPF.forEach { aNumber ->
                lSum += (aNumber.digitToInt() * lMultiplier)
                lMultiplier--
            }

            var lResult = (lSum * 10) % 11

            if (lResult == 10 || lResult == 11)
                lResult = 0

            return lResult == aCPF[lEndPosition].digitToInt()
        }
    }
}