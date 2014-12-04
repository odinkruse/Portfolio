using System;
using System.IO;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ThreadingLAB
{
    public class Threading
    {
        public void threadIO()
        {
            string in_path = @"C:\Users\Odin\Documents\Visual Studio 2010\Projects\OS\ThreadingLAB\in.txt";
            string out_path = @"C:\Users\Odin\Documents\Visual Studio 2010\Projects\OS\ThreadingLAB\out.txt";
            Console.WriteLine("This thread has begun");
            lock (this)
            {
                FileStream fs = File.OpenRead(in_path);
                StreamWriter write = new StreamWriter(out_path);
                byte[] b = new byte[1024];
                UTF8Encoding temp = new UTF8Encoding(true);

                while (fs.Read(b, 0, b.Length) > 0)
                {
                    write.WriteLine(temp.GetString(b));
                }
                write.Close();
            }
        }
    }
}
