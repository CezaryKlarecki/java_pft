package ru.stqa.pft.sandbox;

import org.testng.annotations.*;
import org.testng.*;

public class PrimeTests {
  @Test
  public void TestPrime() {

    Assert.assertTrue(Primes.isPrimeFast(Integer.MAX_VALUE));
  }

  @Test(enabled = false)
  public void TestPrimeLong() {
    long n = Integer.MAX_VALUE;
    Assert.assertTrue(Primes.isPrime(n));
  }


  @Test
  public void TestNonPrime() {

    Assert.assertFalse(Primes.isPrime(Integer.MAX_VALUE - 2));
  }


}
