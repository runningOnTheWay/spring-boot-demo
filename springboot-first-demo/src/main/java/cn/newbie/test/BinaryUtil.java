package cn.newbie.test;

import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * #  类说明：
 * 描述
 *
 * @author [liyunlong]
 * @version [V1.0, 2020/1/15 0015]
 * @package test
 * @since 日期|作者|类型|内容
 * :----|:-----|:-----|:-----
 * 2020/1/15 0015|liyunlong|新增|BinaryUtil新增
 */
public class BinaryUtil {

    /**
     * 求list数值之和(list="1,2,4,8,16,32....")
     * (使用场景是前端将list传入进来.后端计算list之和,然后将结果直接入库)
     *
     * @param list
     * @return
     */
    public static Integer sum(List<Integer> list) {
        if (CollectionUtils.isEmpty(list)) {
            return 0;
        }
        return list.stream().reduce(Integer::sum).orElse(0);
    }

    /**
     * 二进制转换为十进制
     *(在这种方式下,该方法无用)
     *
     * @param binaryString
     * @return
     */
    public static Integer binaryToInteger(String binaryString) {
        Integer i = Integer.parseInt(binaryString, 2);
        return i;
    }

    /**
     * 以base为底数.value为值,算对数.例如
     *     计算64以4为底的对数：
     *     double res = log(64, 4);//4*4*4=64
     *     Assert.isTrue(res==3)
     *
     * @param value
     * @param base
     * @return
     */
    public static double log(double value, double base) {
        return Math.log(value) / Math.log(base);
    }

    /**
     * 十进制数值 转对应的list
     * (使用场景是将DB中对应的int转对应的list,然后将结果返回给前端)
     *
     * @param data
     * @return
     */
    public static List<Integer> toList(Integer data) {
        List<Integer> list = new ArrayList<>();
        if (data <= 0) {
            return list;
        }
        double count = log((double) data, 2d);
        for (int i = 0; i < count + 1; i++) {
            int n = 1 << i;
            if ((data & n) == n) {
                list.add(n);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        List<Integer> realList = toList(22);
        System.out.println(realList.toString());
        int integer = binaryToInteger("00001011");
        Assert.isTrue(11 == integer, "this expression must be true");

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(4);
        list.add(8);
        Integer sum = sum(list);
        System.out.println("sum=" + sum);
        List<Integer> realList1 = toList(sum );
        System.out.println(realList1.toString());
        int data = 100;
        List<Integer> result = toList(data);

        System.out.println("result.size:" + result.size() + "...结果:" + result.toString());
    }
}
