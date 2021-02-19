package org.javaboy.service;/**
 * @author leo
 * @date 2021/2/19
 * @apiNote
 */

/**
 *@ClassName WinShowCmdServiceImpl
 *@Description TODO
 *@Author zhouliansheng
 *@Date 2021/2/19 10:35
 *@Version 1.0
 **/
public class WinShowCmdServiceImpl implements ShowCmdService{
    @Override
    public String showCmd() {
        return "dir";
    }
}
