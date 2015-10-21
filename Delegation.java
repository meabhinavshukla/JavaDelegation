

	public class Delegation {
		public static void main(String args[]) {
			C c = new C();
			System.out.println(c.r());
			D d = new D();
			System.out.println(d.r());
			
			
			C2 c2 = new C2();
			System.out.println(c2.r());
			D2 d2 = new D2();
			System.out.println(d2.r());	
		}
	}

	 abstract class A {
		int a1 = 1;
		int a2 = 2;

		public int f() {
			return a1 + p(100) + q(100);
		}

        protected abstract int p(int m);
        protected abstract int q(int m);
	 }
	
	 
	 class B extends A {
		int b1 = 10;
		int b2 = 20;

		public int g() {
			return f() + this.q(200);
		}

		public int p(int m) {
			return m + b1;
		}

		public int q(int m) {
			return m + b2;
		}
	}
	 

	class C extends B {
		int c1 = 100;
		int c2 = 200;

		public int r() {
			return f() + g() + c1;
			}
		
		public int p(int m) {
			return super.p(m) + super.q(m) + c2;
		}
		
		public int q(int m) {
			return m + a2 + b2 + c2;
		}
	}

	class D extends B {
		int d1 = 300;
		int d2 = 400;
		
		public int p(int m) {
			return m + a1 + b1 + d1;
			
		}
		public int r() {
			return f() + g() + d2;
		}

	}

	
	// Interface definitions
	
	interface IA
	{
			
		public int f();
		public int p(int m);	// abstract
        public int q(int m);	// abstract
	}
	
	interface IB extends IA
	{
				
		public int g();
		public int p(int m);
        public int q(int m);
		
		
	}
	
	interface IC extends IB
	{
		public int r();
		
		public int p(int m);
        public int q(int m);
	}
	
	interface ID extends IB	
	{
		public int r();
		
		public int p(int m);
        
	}
 
	// Classes
	 class A2 implements IA
	{
		int a1 = 1;
		 int a2 = 2;
		
		IA i;
		
		A2(IA i)
		{
			this.i = i;
		}
		
		

		@Override
		public int f() {
			// TODO Auto-generated method stub
			return a1 + p(100) + q(100);
		}

		@Override
		public int p(int m) {
			return i.p(m);
		}

		@Override
		public int q(int m) {
			return i.q(m);
		}
		
	}
	
	class B2 implements IB
	{
		 int b1 = 10;
		 int b2 = 20;
		
		A2 a = null;
		IA i;
		B2(IA i)
		{
			this.i=i;
			a = new A2(this.i);
		}
		
		@Override
		public int f() {
			// TODO Auto-generated method stub
			return a.f();
		}

		@Override
		public int p(int m) {
			// TODO Auto-generated method stub
			return m+b1;
		}

		@Override
		public int q(int m) {
			// TODO Auto-generated method stub
			return m+b2;
		}

		@Override
		public int g() {
			// TODO Auto-generated method stub
			return f() + i.q(200);
		}
		
		
		
	}
	
	class C2 implements IC
	{
		protected int c1 = 100;
		protected int c2 = 200;
		
		A2 a = null;
		B2 b = null;
		//IA i;
		C2()
		{
			//this.i=i;
			b = new B2(this);
			a = new A2(this);
		}
		
		@Override
		public int g() {
			// TODO Auto-generated method stub
			return b.g();
		}

		@Override
		public int f() {
			// TODO Auto-generated method stub
			return a.f();
		}

		@Override
		public int r() {
			// TODO Auto-generated method stub
			return 	f()+ g() + c1;
		}

		@Override
		public int p(int m) {
			// TODO Auto-generated method stub
			return b.p(m) + b.q(m) + c2;
		}

		@Override
		public int q(int m) {
			// TODO Auto-generated method stub
			return m + a.a2 + b.b2 + c2;
		}
		
	}
	
	class D2 implements ID
	{
		protected int d1 = 300;
		protected int d2 = 400;
		
		A2 a = null;
		B2 b = null;
		
		D2()
		{
			//this.i=i;
			b = new B2(this);
			a = new A2(this);
		}
		
		@Override
		public int g() {
			// TODO Auto-generated method stub
			return b.g();
		}

		@Override
		public int q(int m) {
			// TODO Auto-generated method stub
			return b.q(m);
		}

		@Override
		public int f() {
			// TODO Auto-generated method stub
			return a.f();
		}

		@Override
		public int r() {
			// TODO Auto-generated method stub
			return f() + g() + d2;
		}

		@Override
		public int p(int m) {
			// TODO Auto-generated method stub
			return m +a.a1 + b.b1 + d1;
		}
		
	}
	
