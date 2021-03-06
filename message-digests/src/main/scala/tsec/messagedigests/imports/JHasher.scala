package tsec.messagedigests.imports

import tsec.common.ByteUtils.ByteAux
import tsec.common.CryptoTag
import tsec.messagedigests.core._

class JHasher[T: DigestTag](
    algebra: JHashAlgebra[T]
)(implicit gen: ByteAux[T])
    extends HashingPrograms[T](algebra)

object JHasher {

  def apply[T: DigestTag](implicit gen: ByteAux[T]) =
    new JHasher[T](new JHashAlgebra[T])

  implicit def genHasher[T: DigestTag: ByteAux] = apply[T]
}
