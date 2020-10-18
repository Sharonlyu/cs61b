public class NBody{



	public static double readRadius(String doc){//static
		In in = new In(doc);
		in.readInt();//
		double radius= in.readDouble();
		return radius;
	}

	public static Planet[] readPlanets(String doc){//static + type how could it know planet class
		In in = new In(doc);
		int numOfPlanets = in.readInt();
		Planet[] Planets = new Planet[numOfPlanets];//int(type inside)[]
		double radiusOfUniverse = in.readDouble();

		int i = 0;
		while (i < numOfPlanets) {
			double xP = in.readDouble();
			double yP = in.readDouble();
			double xV = in.readDouble();
			double yV = in.readDouble();
			double m = in.readDouble();
			String img = in.readString();
			Planets [i++] = new Planet (xP, yP, xV, yV, m, img);//
		}
		return Planets;
	}
	public static void main(String[] args) {//how to write main line
		double T = Double.parseDouble(args[0]);//why call this on double
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		Planet[] Planets = NBody.readPlanets(filename);//call on nbody
		double radiusOfUniverse = NBody.readRadius(filename);//the radius isn't returned

		StdDraw.setScale(-radiusOfUniverse,radiusOfUniverse);

		StdDraw.clear();//clear the drawing window
		StdDraw.picture(0,0,"images/starfield.jpg");//from (0,0) draw the background

		//Planet[] Plates = readPlanets(filename);//Can they use objects outside main()
		for (Planet planet : Planets){
			planet.draw();
		}
		StdDraw.enableDoubleBuffering();
		double t = 0;

		while (t>=T){
			double[] xForces = new double[Planets.length];//set up new array length not length()!!
			double[] yForces = new double[Planets.length];;
			for (int i=0; i<Planets.length;i++){
				xForces[i]=Planets[i].calcNetForceExertedByX(Planets);//for each planet calc every force
				yForces[i]=Planets[i].calcNetForceExertedByY(Planets);
				
			}
			for (int i=0; i<Planets.length;i++){
				Planets[i].update(dt, xForces[i], yForces[i]);//??
			}
			
			StdDraw.picture(0,0,"images/starfield.jpg");
			for (Planet planet : Planets){
				planet.draw();
			}
			StdDraw.show();
			StdDraw.pause(10);
			t +=dt;
		}
		StdOut.printf("%d\n",Planets.length);
		StdOut.printf("%.2e\n",radiusOfUniverse);
		for (int i=0; i < Planets.length;i++){
			StdOut.printf("%11.4e %11.4e %11.4e %11.4e %12s\n",
				Planets[i].xxPos, Planets[i].yyPos, Planets[i].xxVel,
				Planets[i].yyVel, Planets[i].mass, Planets[i].imgFileName);
		}



	}

	
}


		
	