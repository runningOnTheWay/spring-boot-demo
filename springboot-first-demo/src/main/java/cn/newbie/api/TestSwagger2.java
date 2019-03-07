package cn.newbie.api;

import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "TestSwagger2")
@RestController
@RequestMapping("/testSwagger2")
public class TestSwagger2 {

  @ApiOperation(value = "test测试1")
  @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "Long")
  @RequestMapping(value = "/test1", method = RequestMethod.GET)
  public String testSwagger21(){
    /**
     * 这种方式参数为body里
     **/
    String ss = "1";
    return ss;
  }
  @ApiOperation(value = "test测试2")
  @ApiImplicitParams({
    @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "Long"),
    @ApiImplicitParam(name = "name", value = "用户name", required = false, dataType = "String")
  })
  @RequestMapping(value = "/test2", method = RequestMethod.POST)
  public boolean testSwagger22(){
    /**
     * 这种方式参数为body里
     **/
    boolean bb = false;
    return bb;
  }
  @ApiOperation(value = "test测试3")
  @RequestMapping(value = "/test3", method = RequestMethod.POST)
  public boolean testSwagger23(@RequestParam(required = false) @ApiParam("id") Integer id,
                               @RequestParam(required = false) @ApiParam("姓名") String name,
                               @RequestParam @ApiParam("是否") boolean type){
    /**
     * 这种方式参数为query里
     **/
    boolean bb = false;
    return bb;
  }
}
