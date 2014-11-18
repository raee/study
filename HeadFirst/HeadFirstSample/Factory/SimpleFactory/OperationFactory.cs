using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace HeadFirstSample.Factory.SimpleFactory
{
    /// <summary>
    /// 操作符号
    /// </summary>
    enum OperationType
    {
        Add,
        Sub,
        Mul,
        Div
    }

    /// <summary>
    /// 算法工厂
    /// </summary>
    class OperationFactory
    {
        /// <summary>
        /// 创建算法
        /// </summary>
        /// <param name="type"></param>
        /// <returns></returns>
        public static Operation CrateOperate(OperationType type)
        {
            Operation result = null;
            switch (type)
            {
                case OperationType.Add:
                    result = new AddOperation();
                    break;
                case OperationType.Sub:
                    result = new SubOperation();
                    break;
                case OperationType.Mul:
                    result = new MulOperation();
                    break;
                case OperationType.Div:

                    result = new DivOperation();
                    break;
                default:
                    break;
            }
            return result;
        }
    }
}
