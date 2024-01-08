package org.mapledpmlab.type.skill.attackskill.mercedes;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class FormOfEurel extends AttackSkill {
    public FormOfEurel() {
        this.setName("에우렐의 형상");
        this.setAttackCount(8L);
        this.setDamage(900.0);
        this.setCooldown(10.0);
        this.addFinalDamage(1.6);           // 코어 강화
    }
}
