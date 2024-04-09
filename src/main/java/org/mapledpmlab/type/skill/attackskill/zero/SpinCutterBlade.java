package org.mapledpmlab.type.skill.attackskill.zero;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SpinCutterBlade extends AttackSkill implements AlphaSkill {
    public SpinCutterBlade() {
        this.setName("어드밴스드 스핀 커터(검기)");
        this.setAttackCount(4L);
        this.setDamage(133.0);
        this.setDelayByAttackSpeed(90L);
        this.addFinalDamage(2.2);               // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.getMultiAttackInfo().add(420L);
    }
}
