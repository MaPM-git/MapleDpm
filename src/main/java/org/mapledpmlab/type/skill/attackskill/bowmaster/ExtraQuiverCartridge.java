package org.mapledpmlab.type.skill.attackskill.bowmaster;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class ExtraQuiverCartridge extends AttackSkill {
    public ExtraQuiverCartridge() {
        this.setName("엑스트라 퀴버 카트리지");
        this.setAttackCount(1L);
        this.setDamage(1300.0);
        this.getMultiAttackInfo().add(300L);
    }
}
