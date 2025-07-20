package org.mapledpmlab.type.job;

import org.mapledpmlab.type.ability.BossCriticalAbnormal;
import org.mapledpmlab.type.artifact.ArtifactNormal;
import org.mapledpmlab.type.etc.Common;
import org.mapledpmlab.type.etc.Job;
import org.mapledpmlab.type.etc.JobType;
import org.mapledpmlab.type.hyper.HyperArcher;
import org.mapledpmlab.type.link.*;
import org.mapledpmlab.type.union.DexUnion;

import java.util.stream.Collectors;

public class Bowmaster extends Job {

    public Bowmaster() {
        // 기본
        super();
        this.setName("보우마스터(0초, 리레단일)");
        this.setConstant(1.3);          // 무기상수
        this.setMastery(1.86 / 2);      // 숙련도
        this.setJobType(JobType.ETC);

        this.setAscentDamage(3007632.0);

        Common passive = new Common();
        passive.setDescription("무기");
        passive.addMainStat((long) (150 + 32 + 145));
        passive.addSubStat((long) (150 + 145));
        passive.addAtt((long) (318 + 196 + 72 + 246));
        passive.addBossDamage((long) (30 + 10));
        passive.addIgnoreDefenseList(20L);
        passive.addBossDamage(70L);
        passive.addAttP(9L);
        passive.addAttP(21L);
        passive.addAttP(3L);
        getPassiveList().add(passive);
        this.setWeaponAttMagic((long) (318 + 196 + 72 + 246));

        passive = new Common();
        passive.setDescription("보조무기");
        passive.addMainStat(10L);
        passive.addSubStat(10L);
        passive.addAtt(3L);
        passive.addBossDamage(70L);
        passive.addAttP(9L);
        passive.addAttP(21L);
        getPassiveList().add(passive);

        // 1차
        passive = new Common();
        passive.setDescription("크리티컬 샷");
        passive.addCriticalP(40.0);
        getPassiveList().add(passive);

        // 2차
        passive = new Common();
        passive.setDescription("보우 액셀레이션");
        passive.addMainStat(20L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("소울 애로우 : 활");
        passive.addAtt(30L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("티타늄 화살");
        passive.addAtt(9L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("피지컬 트레이닝");
        passive.addMainStat(30L);
        passive.addSubStat(30L);
        getPassiveList().add(passive);

        // 3차
        passive = new Common();
        passive.setDescription("익스트림 아쳐리 : 활");
        passive.addAtt(40L);
        passive.addFinalDamage(1.3);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("마크맨쉽");
        passive.addAttP(25L);
        passive.addIgnoreDefenseList(25L);
        getPassiveList().add(passive);

        // 4차
        passive = new Common();
        passive.setDescription("어드밴스드 퀴버");
        passive.addFinalDamage(1.06);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("샤프 아이즈");
        passive.addCriticalP(26.0 - 10);
        passive.addCriticalDamage(16.0 - 8);
        passive.addIgnoreDefenseList(5L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("보우 엑스퍼트");
        passive.addAtt(62L);
        passive.addCriticalDamage(16.0);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("일루전 스탭");
        passive.addMainStat(82L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("어드밴스드 파이널 어택");
        passive.addAtt(21L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("아머 피어싱");
        passive.addIgnoreDefenseList(40L);
        passive.addFinalDamage(1.07);
        getPassiveList().add(passive);

        // 환산 보정
        this.addMainStatP(-72L);
        this.addMainStat(15L);
        this.addSubStat(5L);

        this.setAbility(new BossCriticalAbnormal());
        this.setArtifact(new ArtifactNormal());
        this.getLinkList().add(new HybridLogic());
        this.getLinkList().add(new AdventurerCuriosity());
        for (Link link : this.getLinkList()) {
            if (link instanceof CygnusBlessing) {
                this.getLinkList().remove(link);
                break;
            }
        }
        this.getLinkList().add(new PhantomInstinct());
        this.setUnion(new DexUnion());
        this.addPerXMainStat(20L);

        this.addObject(this.getAbility());
        this.addObject(this.getArtifact());
        this.addObject(this.getLinkList().stream().map(s -> (Common) s).collect(Collectors.toList()));
        this.addObject(this.getUnion());
        this.setHyper(new HyperArcher(this.getLevel()));
        this.addObject(this.getHyper());

        this.addObject(getPassiveList());
    }

    @Override
    public void Doping() {
        super.Doping();

        Common doping = new Common();
        doping.setDescription("모탈 블로우");
        doping.addDamage(35L);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("세이람의 영약");
        doping.addCriticalP(-20.0);
        doping.addCriticalDamage(-16.0);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("보우 엑스퍼트(콜렉터의 영약)");
        doping.addAtt(2L);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("일루전 스탭(콜렉터의 영약)");
        doping.addMainStat(2L);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("아머 피어싱(콜렉터의 영약)");
        doping.minusFinalDamage(1.07);
        doping.addFinalDamage(1.08);
        getDopingList().add(doping);

        this.addObject(getDopingList());
    }
}
