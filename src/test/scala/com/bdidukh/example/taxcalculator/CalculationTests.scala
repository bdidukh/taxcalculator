package com.bdidukh.example.taxcalculator

import java.math.BigDecimal

import com.bdidukh.example.taxcalculator.model.goods.{Category, Goods}
import com.bdidukh.example.taxcalculator.model.response.TaxedResponse
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.test.context.junit4.SpringRunner


@RunWith(classOf[SpringRunner])
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CalculationTests {

  @Autowired
  var template: TestRestTemplate = _

  @Test def testGetHelloWorld(): Unit = {
    val result = template.getForObject("/", classOf[String])

    println(result)
  }

  def create(c: Category, d: String, i: Int, p: BigDecimal, imp: Boolean): Goods  = {
    val ss = new Goods(c, d, i, p, imp)
    val g = new Goods(c, d, i, p, imp)
    g
  }

  @Test def testCalculate_Simple1(): Unit = {

    val book = create(Category.BOOK, "Jack London", 1, new BigDecimal(12.49), imp = false)
    val food = create(Category.FOOD, "Roshen", 1, new BigDecimal(0.85), imp = false)
    val music = create(Category.MUSIC, "AC/DC", 1, new BigDecimal(14.9), imp = false)

    val goodsInput = Array(book, food, music)

    val tax = template.postForObject("/", goodsInput, classOf[TaxedResponse])

    val calculatedRes = tax.getSalesTax
    print(calculatedRes)

    assert(new BigDecimal(1.50).compareTo(calculatedRes) == 0)

  }

  @Test def testCalculate_Simple2(): Unit = {


    val food = create(Category.FOOD, "Roshen", 1, new BigDecimal(10.00), imp = true)
    val music = create(Category.MUSIC, "AC/DC", 1, new BigDecimal(47.50), imp = true)

    val goodsInput = Array(food, music)

    val tax = template.postForObject("/", goodsInput, classOf[TaxedResponse])

    val calculatedRes = tax.getSalesTax
    assert(new BigDecimal(7.65).compareTo(calculatedRes) >= 0)

  }

  @Test def testCalculate_Simple3(): Unit = {

    val parfume1 = create(Category.BEAUTY, "Chanel", 1, new BigDecimal(27.99), imp = true)
    val parfume2 = create(Category.BEAUTY, "Chanel 2", 1, new BigDecimal(18.99), imp = false)
    val pills = create(Category.DRUGS, "Pills 1", 1, new BigDecimal(9.75), imp = false)
    val food = create(Category.FOOD, "Roshen", 1, new BigDecimal(11.25), imp = true)

    val goodsInput = Array(parfume1, parfume2, pills, food)

    val tax = template.postForObject("/", goodsInput, classOf[TaxedResponse])

    val calculatedRes = tax.getSalesTax

    assert(new BigDecimal(6.70).compareTo(calculatedRes) >= 0)
  }

}

