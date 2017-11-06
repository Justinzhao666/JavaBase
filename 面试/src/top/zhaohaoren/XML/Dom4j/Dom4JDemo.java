/*
 * Copyright (c) 2017/9/14 by zhaohaoren
 * Welcome to visit my site:
 *  
 *  www.zhaohaoren.top
 *
 * @ Project: JavaCode
 * @ Lan: Java
 * @ author zhaohaoren
 * @ version 1.0 
 * Dom4JDemo Create on 2017/9/14
 */
package top.zhaohaoren.XML.Dom4j;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 *  使用Dom4JDemo解析xml文档
 *
 *  XML的Dom树上 Element表示一个节点，Element中包含
 *
 *  Element 代表 <></>这样的一个 开始结束节点
 *  getName : 获得标签名字
 *  getText ：<>xxx</> 中间的值
 */
public class Dom4JDemo {

    @Test
    public void test() throws DocumentException {
        SAXReader reader = new SAXReader();
        //将xml文档 加载到内存中，放入document树
        Document document = reader.read("src/top/zhaohaoren/XML/Dom4j/Book.xml");
        Element root = document.getRootElement(); // 获取xml里面的根节点： 书架
        /*Element em = root.element("书");  根节点下的书节点
        System.out.println(em.getName());*/
        List list = root.elements(); //获取root下所有的子节点的集合：所有的书节点
        Element em = (Element) list.get(0); //获取第一个子节点，<书 出版社="人民出版社"></书>中所有内容
        System.out.println(em.element("书名").getText()); // em下面也有节点<书名>金瓶梅</书名>
    }

    //遍历XML 所有的标签
    @Test
    public void testIterator() throws DocumentException {
        SAXReader reader = new SAXReader();
        Document document = reader.read("src/top/zhaohaoren/XML/Dom4j/Book.xml");
        Element root = document.getRootElement();
        treeWalk(root);
    }

    private void treeWalk(Element em){
        System.out.println(em.getName()); //当前标签的标签名
        for (int i=0;i<em.nodeCount();i++){ // 计算该节点下子节点的数量
            Node node = em.node(i); // 第i个子节点
            if (node instanceof Element){
                treeWalk((Element) node); // 如果该节点下面还有子节点，并且是Element的话则递归
            }
        }
    }

}
