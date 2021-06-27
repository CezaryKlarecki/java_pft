package ru.stqa.pft.soap;

import com.lavasoft.GeoIPService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GeoIpServiceTests {

  @Test
  public void testMyIp(){
    String geoIP= new GeoIPService().getGeoIPServiceSoap12().getIpLocation( "79.184.213.78");
    Assert.assertEquals(geoIP, "<GeoIP><Country>PL</Country><State>86</State></GeoIP>");

  }


  @Test
  public void testInvalidIp(){
    String geoIP= new GeoIPService().getGeoIPServiceSoap12().getIpLocation( "79.184.213.xx");
    Assert.assertEquals(geoIP, "<GeoIP><Country>PL</Country><State>86</State></GeoIP>");

  }
}
