/*********************************
 * @Description:美团面试题含答案 *
 * @Author:Stan                  *     
 * @Date:2018/08/19 19:11        *
 ********************************/
 
/***********试题部分*************/
/*
 * 说一下常用的排序算法。 
 * 说一下快排的思想。 
 * 一个有序数组集合，找一个下标，你的思路是什么。 
 * 完全二叉树和满二叉树的区别。  
 * Activity的生命周期相关。 
 * 从栈顶Activity回到栈底Activity的解决方法都有什么。 
 * 异常情况杀死Activity怎么保存数据。 
 * 卡顿情况的产生，定位和解决。 
 * View的整体绘制流程。 
 * 手写一个方法获得当前布局的层级深度。 
 * 常用的垃圾回收。 
 * 谈一谈JVM。 谈一谈你对MVP和MVVM的看法
*/
/*
 * 手写输出一个二叉树的侧面图。 
 * 手写一个你最熟悉的排序算法。 
 * 有一个类怎样改变内部final类型的变量。 
 * final修饰变量、方法、类都有什么特性。 
 * static修饰变量、方法、类都有什么特性。 
 * 处理过内存泄漏么，都用什么样的方法处理的，为什么。 
 * 说一下你经历的项目中印象最深刻的一个点。 
 * 聊一聊你最擅长的安卓地方。 
 * 看过哪些开源项目，聊一聊。
*/
/*
 * 手写二叉树的按层级进行遍历。 
 * 图的深度遍历的实现方法。 
 * 消费者生产者模型。 
 * 聊一聊aidl，谈一谈Binder机制，Service通讯的方案。 
 * 最近在做什么，（做锁屏），聊一聊实现的思路，怎么提高锁屏出现的成功率。 
 * 自定义View思路，需要注意什么。 
 * Handler机制，为什么loop是死循环。 
 * 聊一聊你做的最复杂的自定义View。 
 * 聊一聊事件分发
*/  

/***********答案部分*************/
/* 
 * 满二叉树：除最后一层无任何子节点外，每一层上的所有结点都有两个子结点（最后一层上的无子结点的结点为叶子结点）。
 * 满二叉树特性：(满二叉树和完全二叉树通常采用数组存储)
 * 第k层的节点数：2^(k - 1)
 * k层节点总数：2^k - 1
 * 第i个节点(从0开始)的左孩子和有孩子为：2 * i + 1 和 2 * i + 2
 * 完全二叉树：若设二叉树的深度为h，除第 h 层外，其它各层 (1～h-1) 的结点数都达到最大个数，第 h 层所有的结点都连续集中在最左边，这就是完全二叉树。
*/