import org.junit.Assert
import org.junit.Test

fun main(args: Array<String>) {
    val cpf = CPF
    val cnpj = CNPJ

    println(cpf.isValid("115.754.049-07"))
    println(cnpj.isValid("63013663000160"))
}

class validatesCPFTest {
    private val cpf = CPF
    private val cnpj = CNPJ

    @Test
    fun validatesCPF() {
        Assert.assertEquals(true, cpf.isValid("11575404907"))
        Assert.assertEquals(true, cpf.isValid("115.754.049-07"))
        Assert.assertEquals(true, cpf.isValid("53608032070"))
        Assert.assertEquals(true, cpf.isValid("536.080.320-70"))
        Assert.assertEquals(true, cpf.isValid("97677498027"))
        Assert.assertEquals(true, cpf.isValid("976.774.980-27"))
        Assert.assertEquals(false, cpf.isValid("97677498067"))
        Assert.assertEquals(false, cpf.isValid("976.774.980-67"))
        Assert.assertEquals(false, cpf.isValid("97677498097"))
        Assert.assertEquals(false, cpf.isValid("976.774.980-97"))
        Assert.assertEquals(false, cpf.isValid("11111111111"))
        Assert.assertEquals(false, cpf.isValid("111.111.111-11"))
        Assert.assertEquals(false, cpf.isValid("33333333333"))
        Assert.assertEquals(false, cpf.isValid("333.333.333-33"))
        Assert.assertEquals(true, cpf.isValid("25390249046"))
        Assert.assertEquals(true, cpf.isValid("253.902.490-46"))
        Assert.assertEquals(false, cpf.isValid("25390249049"))
        Assert.assertEquals(false, cpf.isValid("253.902.490-49"))
        Assert.assertEquals(true, cpf.isValid("76635368000"))
        Assert.assertEquals(true, cpf.isValid("766.353.680-00"))
        Assert.assertEquals(false, cpf.isValid("76635368054"))
        Assert.assertEquals(false, cpf.isValid("766.353.680-54"))

        Assert.assertEquals(true, cnpj.isValid("63013663000160"))
        Assert.assertEquals(true, cnpj.isValid("85.962.823/0001-50"))
    }
}







