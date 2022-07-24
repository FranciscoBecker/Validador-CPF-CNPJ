class CNPJ {
    companion object {
        fun isValid(aCNPJ: String): Boolean {
            val lCNPJ = removeMask(aCNPJ)
            return hasFourteenNumbers(lCNPJ) and
                    !isRepeatedNumbers(lCNPJ) and
                    areDigitsValid(lCNPJ, true) and
                    areDigitsValid(lCNPJ, false)
        }

        private fun removeMask(aCNPJ: String): String {
            return aCNPJ.replace(".", "")
                .replace("/", "")
                .replace("-", "")
        }

        private fun hasFourteenNumbers(aCNPJ: String) = aCNPJ.length == 14

        private fun isRepeatedNumbers(aCNPJ: String): Boolean {
            for (lNumber in aCNPJ) {
                if (lNumber != aCNPJ[0])
                    return false
            }
            return true
        }

        private fun areDigitsValid(aCNPJ: String, aIsFirstDigit: Boolean): Boolean {
            var lSum = 0
            var lMultiplier = if (aIsFirstDigit) 5 else 6
            val lEndPosition = if (aIsFirstDigit) 12 else 13
            val lRootCNPJ = aCNPJ.substring(0, lEndPosition)

            for (lNumber in lRootCNPJ) {
                lSum += lNumber.digitToInt() * lMultiplier
                lMultiplier--
                if (lMultiplier == 1)
                    lMultiplier = 9
            }

            var lResult = lSum % 11
            lResult = if (lResult < 2) 0 else 11 - lResult

            return lResult == aCNPJ[lEndPosition].digitToInt()
        }
    }
}