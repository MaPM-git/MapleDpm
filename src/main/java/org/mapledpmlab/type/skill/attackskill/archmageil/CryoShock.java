package org.mapledpmlab.type.skill.attackskill.archmageil;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class CryoShock extends AttackSkill {
    public CryoShock() {
        this.setName("크라이오 쇼크");
        this.setDamage(1090.0 + 687);
        this.setAttackCount(15L);
        this.addFinalDamage(1.08);          // 오버로드 마나
    }
}
