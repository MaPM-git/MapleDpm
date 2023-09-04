package org.mapledpmlab.type.skill.buffskill.flamewizard;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class SalamanderMischiefBuff extends BuffSkill {
    public SalamanderMischiefBuff() {
        this.setName("샐리맨더 미스칩(버프)");
        this.setDuration(30L);
        this.addBuffAttMagic(105L);
    }
}
