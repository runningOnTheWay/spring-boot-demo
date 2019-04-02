package cn.newbie.api;

import com.sun.org.glassfish.gmbal.Description;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * #  类说明：
 * 描述
 *
 * @author [liyunlong]
 * @version [V1.0, 2019/4/2 0002]
 * @package cn.newbie.api
 * @since 日期|作者|类型|内容
 * :----|:-----|:-----|:-----
 * 2019/4/2 0002|liyunlong|新增|TestDto新增
 */
@Data
public class TestDto {
  @ApiModelProperty(value = "id")
  private int id;
  @ApiModelProperty(value = "age")
  private int age;
  @ApiModelProperty(value = "name")
  private String name;
  @ApiModelProperty(value = "className")
  private String className;
}
