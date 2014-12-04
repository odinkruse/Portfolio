using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.IO;

namespace ThreadingLAB
{
    public class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Enter Main");                                        //
            Threading classvar = new Threading();
            classvar.makesomethreads();
            classvar.threadIO();//
            Console.Read();                                                         //
        }
        public class Threading
        {
            public void makesomethreads()
            {
                                                   //
                Thread classthread2 = new Thread(new ThreadStart(threadIO));   //
                Thread classthread1 = new Thread(new ThreadStart(threadIO));   //                                               //                                                    //
                classthread1.Start();
                classthread2.Start();
            }
            public void threadIO()
            {
                Object threadLock = new object();
                lock(this)
                {
                string in_path = @"C:\Users\Odin\Documents\Visual Studio 2010\Projects\OS\ThreadingLAB\in.txt";
                string out_path = @"C:\Users\Odin\Documents\Visual Studio 2010\Projects\OS\ThreadingLAB\out.txt";
                Console.WriteLine("In threadIO");
                FileStream fs = File.OpenRead(in_path);
                byte[] b = new byte[512];
                UTF8Encoding temp = new UTF8Encoding(true);
                while (fs.Read(b, 0, b.Length) > 0)
                {
                    StreamWriter write = File.AppendText(out_path);
                    write.WriteLine(temp.GetString(b));
                    write.Close();
                }
                }
            }
        }
    }
}
