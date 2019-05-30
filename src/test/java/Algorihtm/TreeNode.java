package Algorihtm;

/**
 * @author : ZJ
 * @date : 19-1-7 下午4:13
 */
public class TreeNode<T> {
    private T value;
    private TreeNode<T> leftChild;
    private TreeNode<T> rightChild;

    public TreeNode(T value) {
        this.value = value;
    }
    TreeNode(){}
    /**   增加左子节点
     * addLeft:
     * @param value
     * void  返回类型
     */
    public void addLeft(T value){
        TreeNode<T> leftChild = new TreeNode<T>(value);
        this.leftChild = leftChild;
    }
    /**
     * addRight: 增加右子节点
     * @param value
     * void  返回类型
     */
    public void addRight(T value){
        TreeNode<T> rightChild = new TreeNode<T>(value);
        this.rightChild = rightChild;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public TreeNode<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode<T> leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode<T> rightChild) {
        this.rightChild = rightChild;
    }
}
