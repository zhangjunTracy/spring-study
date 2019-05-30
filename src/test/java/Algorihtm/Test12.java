package Algorihtm;

import org.apache.commons.lang3.StringUtils;

/**
 * @author : ZJ
 * @date : 19-1-3 下午1:04
 */
public class Test12 {
    public static void main(String[] args) {

    }

    public static <T> int getTreeNum(TreeNode<T> root) {
        if (root == null) {
            return 0;
        }
        return getTreeNum(root.getLeftChild()) + getTreeNum(root.getLeftChild()) + 1;
    }

}
