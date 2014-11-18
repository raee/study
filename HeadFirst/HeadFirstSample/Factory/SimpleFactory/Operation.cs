using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace HeadFirstSample.Factory.SimpleFactory
{
    /// <summary>
    /// 计算类
    /// </summary>
    public class Operation
    {
        public double NumberA { get; set; }
        public double NumberB { get; set; }

        /// <summary>
        /// 计算结果
        /// </summary>
        /// <returns></returns>
        public virtual double GetResult()
        {
            return 0;
        }
    }
}
