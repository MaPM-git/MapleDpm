package org.mapledpmlab.type.skill.attackskill.cadena;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class ADOrdnanceSphere extends AttackSkill {
    public ADOrdnanceSphere() {
        this.setName("A.D 오드넌스(구체)");
        this.setDamage(1650.0);
        this.setAttackCount(8L);
        this.addFinalDamage(1.6);           // 코어 강화
        this.getMultiAttackInfo().add(9120L - 450);
    }
}
