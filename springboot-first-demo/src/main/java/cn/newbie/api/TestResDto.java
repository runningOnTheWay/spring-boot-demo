package cn.newbie.api;

import com.sun.org.glassfish.gmbal.Description;
import lombok.Data;

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
public class TestResDto {
  @Description(value = "idr")
  private int idr;
  @Description(value = "ager")
  private int ager;
  @Description(value = "namer")
  private String namer;
  @Description(value = "classNamer")
  private String classNamer;
}
