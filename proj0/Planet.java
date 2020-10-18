
public class Planet{
	double xxPos;
	double yyPos;
	double xxVel;
	double yyVel;
	double mass;
	String imgFileName;

	public Planet(double xP, double yP, double xV, double yV, double m, String img){
		xxPos=xP;
		yyPos=yP;
		xxVel=xV;
		yyVel=yV;
		mass=m;
		imgFileName=img;

	}
	public Planet(Planet p){
		Planet pCopy=p;
	    xxPos=p.xxPos;
		yyPos=p.yyPos;
		xxVel=p.xxVel;
		yyVel=p.yyVel;
		mass=p.mass;
		imgFileName=p.imgFileName;

	}
	public double calcDistance(Planet p2){

		double dx=this.xxPos-p2.xxPos;
		double dy=this.yyPos-p2.yyPos;
		double r=Math.sqrt(dx*dx+dy*dy);
		return r;
	}

	public double calcForceExertedBy(Planet p2){
		double G = 6.67e-11;
		double m1 = this.mass;
		double m2 = p2.mass;
		double F = G*m1*m2/(this.calcDistance(p2)*this.calcDistance(p2));
		return F;

	}
	public double calcForceExertedByX(Planet p2){
		double F = this.calcForceExertedBy(p2);
		
		double Fx = F*(p2.xxPos-this.xxPos)/this.calcDistance(p2);
		
		return Fx;

		}
	
	
	public double calcForceExertedByY(Planet p2){
		double F = this.calcForceExertedBy(p2);
		
		double Fy = F*(p2.yyPos-this.yyPos)/this.calcDistance(p2);
		//Pay attention to the sign, p2.pos-p.pos
		
		return Fy;

		}
	public double calcNetForceExertedByX(Planet [] allPlanets){
		double FnetX = 0;
		for (Planet p : allPlanets){
			if (p == this){
				continue;
			}
			FnetX = FnetX +this.calcForceExertedByX(p);
		}
		return FnetX;
	}
	public double calcNetForceExertedByY(Planet [] allPlanets){
		double FnetY = 0;
		for (Planet p : allPlanets){
			if (p == this){
				continue;
			}
			FnetY = FnetY +this.calcForceExertedByY(p);
		}
		return FnetY;
	}
	public void update(double dt, double fX, double fY){//pass by refernce, no need to return
		double aX = fX/this.mass;
		double aY = fY/this.mass;
		this.xxVel += dt*aX;
		this.yyVel += dt*aY;
		this.xxPos += dt*xxVel;
		this.yyPos += dt*yyVel;
		


	}
	public void draw(){
		StdDraw.picture(this.xxPos, this.yyPos, "images/"+this.imgFileName);//draw the file on that pos

	}

}


