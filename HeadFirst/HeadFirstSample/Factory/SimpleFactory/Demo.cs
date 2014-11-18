using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using NUnit.Framework;

namespace HeadFirstSample.Factory.SimpleFactory
{
    [TestFixture]
    class Demo : SmapleDemo
    {
        [Test]
        public override void ShowDemo()
        {
            Operation op = OperationFactory.CrateOperate(OperationType.Mul);
            op.NumberA = 10;
            op.NumberB = 2;
            double result = op.GetResult();
            Console.WriteLine("result:" + result);
        }
    }
}
