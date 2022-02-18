package a1DataStructures.ds8AVLTrees.avlGeneric;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
public class Node<T> {

	private T data;
	private Node<T> leftNode;
	private Node<T> rightNode;
	private int height;

	public Node(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return this.data.toString();
	}
}
