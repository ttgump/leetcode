/*
A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.
*/

/*
http://mp.weixin.qq.com/mp/appmsg/show?__biz=MjM5ODIzNDQ3Mw==&appmsgid=10000291&itemidx=1&sign=ccde63918a24dee181f1fd1a4e3e6781
分析
这个问题的关键就在于random指针如何完成拷贝，next指针一次遍历就完成了，random指针拷贝的关键在于，如何找到random指向的节点对应的新的节点。一般来讲，大家会想到用map来保存旧的节点到新的节点的映射，这样得到方法的时间复杂度为O(n)，空间复杂度为O(n)。下面 是一个可行的方法：oldlist为原始链表，copylist为新的链表，oldnode为oldlist中的节点，copynode为 copylist中的节点：
1.根据oldlist，创建copylist，只拷贝next指针
2.保存oldnode到oldnode.next的映射
3.将oldlist中的oldnode的next指针指向copylist中对应的copynode
4.将copylist中的copynode的random指针指向oldlist中对应的oldnode
5.对于copylist中的每一个节点：copynode.random=copynode.random.random.next
6.根据第2步，建立的映射，恢复oldlist
上面这个方法，需要额外的映射。下面介绍一个巧妙的方法，可以省去映射的部分
1.对oldlist中的节点，依次作如下的操作：对于第i个节点oldnode[i]，生成拷贝节点copynode[i]，并且插入在oldnode[i]和oldnode[i+1]之间，最后一个节点直接附加到oldlist后面即可。
2.处理每一个copynode的random拷贝，及对每一个copynode=oldnode.next, oldnode.next.random=oldnode.random.next 后面的next确保是copynode。
3.通过如下的操作，恢复oldlist，以及生成copylist 1) oldnode.next = oldnode.next.next 2) copynode.next = copynode.next.next 这里要注意，oldnode的最后一个节点，next是null
注意题目中的random可能指向null，在上面第2步的时候处理一下就可以了。
*/

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) return null;
        RandomListNode itr = head;
        while(itr != null) {
            RandomListNode temp = new RandomListNode(itr.label);
            temp.random = null;
            RandomListNode itr2 = itr;
            itr = itr.next;
            itr2.next = temp;
            temp.next = itr;
        }
        
        itr = head;
        while(itr != null) {
            if(itr.random != null) {
                itr.next.random = itr.random.next;
            }
            else {
                itr.next.random = null;
            }
            itr = itr.next.next;
        }
        
        itr = head;
        RandomListNode copyList = itr.next;
        RandomListNode copyListHead = copyList;
        while(itr != null) {
            itr.next = copyList.next;
            if(copyList.next == null)
                copyList.next = null;
            else
                copyList.next = copyList.next.next;
            itr = itr.next;
            copyList = copyList.next;
        }
        
        return copyListHead;
    }
}