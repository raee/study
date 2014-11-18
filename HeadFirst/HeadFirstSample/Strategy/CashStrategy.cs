using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace HeadFirstSample.Strategy
{
    /// <summary>
    /// 现金抽象策略
    /// </summary>
    public abstract class CashStrategy
    {
        /// <summary>
        /// 计算促销方法
        /// </summary>
        /// <param name="money">原价</param>
        /// <returns></returns>
        public abstract double AcceptCash(double money);
    }
}
