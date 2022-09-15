package design_patterns;

public abstract class NodeVisitor {
	public abstract void visitFacade(PTBSFacade facade);
    public abstract void visitTrading(Trading trading);
    public abstract void visitProduct(Product product);
}
