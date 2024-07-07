package org.mapledpmlab.type.skill.attackskill.kinesis;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class EverPsychicFinish extends AttackSkill {
    public EverPsychicFinish() {
        this.setName("에버싸이킥(마무리 일격)");
        this.setDamage(1500.0);
        this.setAttackCount(1L);
        this.getMultiAttackInfo().add(6900L - 60);
        this.addIgnoreDefenseList(50L);
        this.addFinalDamage(1.08);          // 오버로드 마나
    }
}
