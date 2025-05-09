public class BST<K extends Comparable<K>, V> {
    private Node root;

    private class Node {
        private K key;
        private V val;
        private Node left, right;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }

    public void put(K key, V val) {
        root = put(root, key, val);
    }

    private Node put(Node node, K key, V val) {
        if (node == null) return new Node(key, val);
        int cmp = key.compareTo(node.key);
        if (cmp < 0)
            node.left = put(node.left, key, val);
        else if (cmp > 0)
            node.right = put(node.right, key, val);
        else
            node.val = val;
        return node;
    }

    public V get(K key) {
        Node node = root;
        while (node != null) {
            int cmp = key.compareTo(node.key);
            if (cmp < 0)
                node = node.left;
            else if (cmp > 0)
                node = node.right;
            else
                return node.val;
        }
        return null;
    }

    public void delete(K key) {
        root = delete(root, key);
    }

    private Node delete(Node node, K key) {
        if (node == null) return null;
        int cmp = key.compareTo(node.key);

        if (cmp < 0)
            node.left = delete(node.left, key);
        else if (cmp > 0)
            node.right = delete(node.right, key);
        else {
            // Node with one or no child
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;

            // Replace with min from right subtree
            Node min = getMin(node.right);
            node.key = min.key;
            node.val = min.val;
            node.right = delete(node.right, min.key);
        }
        return node;
    }

    private Node getMin(Node node) {
        while (node.left != null)
            node = node.left;
        return node;
    }

    public Iterable<K> iterator() {
        java.util.List<K> keys = new java.util.ArrayList<>();
        inorder(root, keys);
        return keys;
    }

    private void inorder(Node node, java.util.List<K> keys) {
        if (node == null) return;
        inorder(node.left, keys);
        keys.add(node.key);
        inorder(node.right, keys);
    }
}
