using NUnit.Framework;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace HeadFirstSample
{
    /// <summary>
    /// 程序演示程序
    /// </summary>
    [TestFixture]
    public abstract class SmapleDemo
    {
        [Test]
        public abstract void ShowDemo();
    }
}
