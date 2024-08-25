package org.mapledpmlab.type.skill.attackskill.illium;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class GloryWingMortalWingBeat extends AttackSkill {
    public GloryWingMortalWingBeat() {
        this.setName("글로리 윙:모탈 윙비트");
        this.setDamage(2200.0);
        this.setDelayByAttackSpeed(840L);
        this.setAttackCount(15L);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.getMultiAttackInfo().add(0L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.setApplyFinalAttack(true);
        this.addFinalDamage(1.08);  // 오버로드 마나
    }
}
