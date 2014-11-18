using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace HeadFirstSample.Factory.SimpleFactory
{
    /// <summary>
    /// 加法
    /// </summary>
    public class AddOperation : Operation
    {
        public override double GetResult()
        {
            return NumberA + NumberB;
        }
    }

    /// <summary>
    /// 减法
    /// </summary>
    public class SubOperation : Operation
    {
        public override double GetResult()
        {
            return NumberA - NumberB;
        }
    }

    /// <summary>
    /// 乘法
    /// </summary>
    public class MulOperation : Operation
    {
        public override double GetResult()
        {
            return NumberA * NumberB;
        }
    }

    /// <summary>
    /// 除法
    /// </summary>
    public class DivOperation : Operation
    {
        public override double GetResult()
        {
            if (NumberB == 0)
            {
                throw new Exception("被除数不能为0");
            }
            return NumberA / NumberB;
        }
    }

}
