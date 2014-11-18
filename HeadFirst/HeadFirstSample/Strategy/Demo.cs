using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using NUnit.Framework;

namespace HeadFirstSample.Strategy
{
    [TestFixture]
    public class Demo : SmapleDemo
    {
        [Test]
        public override void ShowDemo()
        {
            CashContext context = null;
            context = new CashContext(new CashNomral()); 
            context = new CashContext(new CashRebate(0.5));
            context = new CashContext(new CashReturn(300, 100));

            double result = context.GetResult(200);

            Console.WriteLine(result);

        }
    }
}
